using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace BlogDbApp
{
    class PostData
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public DateTime Date { get; set; }
    }

    class Program
    {
        static void Main(string[] args)
        {
            var db = new BlogDbContext();

            //CreateNewPosts(db);
            //ReadComments(db);
            //ReadPostsAndComments(db);
            //ReadPostTitlesWithID(db);
            //UpdateData(db);
            //DeleteLastPost(db);
            //InsertPostWithComments(db);
            //SortDatesNativeSQL(db);
            //MoveComments(db);
        }

        private static void SortDates(BlogDbContext db)
        {
            var startDate = new DateTime(2016, 05, 19);
            var endDate = new DateTime(2016, 06, 14);
            var posts = db.Database.SqlQuery<PostData>(
              @"SELECT ID, Title, Date FROM Posts
    WHERE CONVERT(date, Date)
    BETWEEN {0} AND {1}
    ORDER BY Date",
              startDate, endDate); // If you want to debug it, make it to list -> .toList();
            foreach (var p in posts)
                Console.WriteLine(
                  $"#{p.ID}: {p.Title} ({p.Date})");
        }

        private static void MoveComments(BlogDbContext db)
        {
            var userGoshe = db.Users.Where(u => u.Username == "Goshe").First();
            var userAdmin = db.Users.Where(u => u.Username == "admin").First();

            foreach (var c in db.Comments.Where(c => c.AuthorID == userGoshe.ID))
            {
                c.AuthorID = userAdmin.ID;
                c.AuthorName = userAdmin.FullName;
                //     OR
                // c.Author = userAdmin;
            }

            db.SaveChanges();
        }

        private static void DeleteLastPost(BlogDbContext db)
        {
            var lastPost = db.Posts
              .OrderByDescending(p => p.ID)
              .First();
            db.Comments.RemoveRange(
              lastPost.Comments);
            lastPost.Tags.Clear();
            db.Posts.Remove(lastPost);
            db.SaveChanges();
            Console.WriteLine(
              $"Deleted post #{lastPost.ID}");
        }

        private static void UpdateData(BlogDbContext db)
        {
            var user = db.Users
    .Where(u => u.Username == "merrry")
    .FirstOrDefault();

            user.PasswordHash = new byte[] { 1, 2, 3, 4, 5 };
            user.Username = "GOSHE";
            user.FullName = "Леля Мери";

            db.SaveChanges();
            Console.WriteLine(
                "User #{0} ({1}) has a new password, new username - {2} and new fullname - {3}.",
                user.ID, user.Username, user.Username, user.FullName);
        }

        private static void InsertPostWithComments(BlogDbContext db)
        {
            var post = new Post()
            {
                Title = "New Post Title",
                Date = DateTime.Now,
                Body = "This post have comments and tags",
                User = db.Users.First(),
                Comments = new Comment[] {
    new Comment() { Text = "Comment 1", Date = DateTime.Now },
    new Comment() { Text = "Comment 2", Date = DateTime.Now,
      Author = db.Users.First() } },
                Tags = db.Tags.Take(3).ToList()
            };
            db.Posts.Add(post);
            db.SaveChanges();
        }

        private static void CreateNewPosts(BlogDbContext db)
        {
            var p = new Post()
            {
                Body = "Hello, I`m the new one!",
                Title = "New post",
                Date = DateTime.Now

            };
            db.Posts.Add(p);

            var p2 = new Post()
            {
                Body = "Hello, I`m second!",
                Title = "Second post",
                Date = DateTime.Now

            };
            db.Posts.Add(p2);
            db.SaveChanges();

            Console.WriteLine("Added posts: #{0}, #{1}", p.ID, p2.ID);
        }

        private static void GetComments(BlogDbContext db)
        {
            var commentsQuery = db.Comments.Select(c => new
            {
                ID = c.ID,
                Author = c.AuthorName ?? c.Author.FullName,
                Text = c.Text
            });

            foreach (var c in commentsQuery)
            {
                Console.WriteLine($"{c.ID} - {c.Author} - {c.Text}");
            }
        }

        private static void GetPostTitlesWithID(BlogDbContext db)
        {
            var postsQuery = db.Posts.Select(p => new
            {
                PostID = p.ID,
                PostTitle = p.Title,
                TagsCount = p.Tags.Count(),
                CommentsCount = p.Comments.Count(),
                Comments = p.Comments.Select(c => c.Text),
                AuthorName = p.User.FullName
            }).ToList();

            foreach (var p in postsQuery)
            {
                Console.WriteLine($"#{p.PostID} - {p.PostTitle}, {string.Join("; ", p.Comments)}");
            }
        }

        private static void GetPostsAndComments(BlogDbContext db)
        {
            foreach (var post in db.Posts)
            {
                Console.WriteLine(post.ID + " " + post.Title);
                foreach (var comment in post.Comments)
                {
                    Console.WriteLine($"\t {comment.Text}");
                }
            }
        }
    }
}
