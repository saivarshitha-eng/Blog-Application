
import { useState } from 'react';
import api from './axios';

function EditPost({ post, onUpdated, onCancel }) {

    const [title, setTitle] = useState(post.title);
    const [content, setContent] = useState(post.content);
    const [author, setAuthor] = useState(post.author);

    const handleUpdate = async (e) => {
        e.preventDefault();

        try {
            await api.put(`/posts/${post.id}`, {
                title,
                content,
                author
            });

            alert('Post updated successfully!');
            onUpdated();

        } catch (error) {
            console.log(error);
            alert('Unable to update post!');
        }
    };

    return (
        <div className="form-container">

            <h2>Edit Post</h2>

            <form onSubmit={handleUpdate}>

                <input
                    type="text"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    required
                />

                <textarea
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                    required
                />

                <input
                    type="text"
                    value={author}
                    onChange={(e) => setAuthor(e.target.value)}
                    required
                />

                <button type="submit">Update Post</button>

                <button type="button" onClick={onCancel}>
                    Cancel
                </button>

            </form>

        </div>
    );
}

export default EditPost;
