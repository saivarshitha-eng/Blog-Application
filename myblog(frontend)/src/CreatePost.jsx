
import { useState } from 'react';
import api from './axios';

function CreatePost({ onCreated }) {

    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [author, setAuthor] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            await api.post('/posts', {
                title,
                content,
                author
            });

            alert('Post created successfully!');

            setTitle('');
            setContent('');
            setAuthor('');
            onCreated();

        } catch (error) {
            console.log(error);
            alert('Unable to create post!');
        }
    };

    return (
        <div className="form-container">

            <h2>Create New Post</h2>

            <form onSubmit={handleSubmit}>

                <input
                    type="text"
                    placeholder="Enter Title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                    required
                />

                <textarea
                    placeholder="Enter Content"
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                    required
                />

                <input
                    type="text"
                    placeholder="Enter Author"
                    value={author}
                    onChange={(e) => setAuthor(e.target.value)}
                    required
                />

                <button type="submit">Create Post</button>

            </form>

        </div>
    );
}

export default CreatePost;
