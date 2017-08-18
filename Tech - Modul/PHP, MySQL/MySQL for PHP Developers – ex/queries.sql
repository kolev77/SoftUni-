SELECT * FROM posts;
SELECT title, content FROM posts;
SELECT username, fullname FROM users ORDER BY username DESC;
SELECT username, fullname FROM users ORDER BY fullname DESC, username DESC;
SELECT * FROM users WHERE id IN (SELECT user_id FROM posts);
SELECT
  users.username, posts.title
FROM
	users
		JOIN
	posts ON users.id = posts.user_id;
    
SELECT username, fullname
FROM users
WHERE id IN (
SELECT user_id FROM posts WHERE id = 4);


SELECT username, fullname
FROM users
WHERE id IN (
SELECT user_id FROM posts ORDER BY id DESC);
INSERT INTO posts (user_id, title, content)
VALUES ('2', 'NEW TITLE', 'Some new content... New New New');
SELECT * FROM POSTS;
UPDATE posts SET title = 'Updated title' WHERE post_id = 9;
DELETE FROM posts where post_id = 9;

