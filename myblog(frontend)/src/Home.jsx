
import { useEffect, useState } from 'react';
import api from './axios';
import CreatePost from './CreatePost';
import EditPost from './EditPost';

function Home() {

    const [posts, setPosts] = useState([]);
    const [selectedPost, setSelectedPost] = useState(null);

    const fetchPosts = async () => {
        try {
            const res = await api.get('/posts');
            setPosts(res.data);
        } catch (error) {
            console.log(error);
            alert('Unable to fetch posts!');
        }
    };

    useEffect(() => {
        fetchPosts();
    }, []);

    const handleDelete = async (id) => {
        if (!window.confirm('Do you want to delete this post?')) {
            return;
        }

        try {
            await api.delete(`/posts/${id}`);
            alert('Post deleted successfully!');
            fetchPosts();
        } catch (error) {
            console.log(error);
            alert('Unable to delete post!');
        }
    };

    return (
        <div className="container">

            <h1>My Blog Application</h1>

            <CreatePost onCreated={fetchPosts} />

            {selectedPost && (
                <EditPost
                    post={selectedPost}
                    onUpdated={() => {
                        setSelectedPost(null);
                        fetchPosts();
                    }}
                    onCancel={() => setSelectedPost(null)}
                />
            )}

            <h2>All Blog Posts ({posts.length})</h2>

            {posts.map((post) => (
                <div className="post-card" key={post.id}>

                    <h3>{post.title}</h3>
                    <p>{post.content}</p>
                    <small>Author: {post.author}</small>

                    <br />

                    <button onClick={() => setSelectedPost(post)}>
                        Edit
                    </button>

                    <button onClick={() => handleDelete(post.id)}>
                        Delete
                    </button>

                </div>
            ))}

        </div>
    );
}

export default Home;
