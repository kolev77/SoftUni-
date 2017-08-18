using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace EntityFramework
{
    class Program
    {
        static void Main(string[] args)
        {
            BlogDbContext blogDbContext = new BlogDbContext();


            //DeletePostByIdAndItsCommentsAndTags(blogDbContext);
            //DeleteCommentByID(blogDbContext);
            //UpdateData(blogDbContext);
            //CreateNewPost(blogDbContext);
            //OrderPostsAuthors(blogDbContext);
            //SelectAuthorOfSpecificPost(blogDbContext);
            //JoinsAuthorsWithTitles(blogDbContext);
            //OnlyUsersWithPosts(blogDbContext);
            //OrderByTwoColumns(blogDbContext);
            //OrderByUserName(blogDbContext);
            //ListTitleAndBodyFromPosts(blogDbContext);
            // ListAllUsers(users);
            // ListAllPosts(blogDbContext);
        }

        private static void DeletePostByID(BlogDbContext blogDbContext)
        {
            Post postInfo = blogDbContext.Posts.Single(post => post.Id == 31);

            blogDbContext.Comments.RemoveRange(postInfo.Comments);
            postInfo.Tags.Clear();

            blogDbContext.Posts.Remove(postInfo);

            blogDbContext.SaveChanges();

            Console.WriteLine("Post #{0} deleted successfully", postInfo.Id);
        }

        private static void DeleteCommentByID(BlogDbContext blogDbContext)
        {
            Comment commentInfo = blogDbContext.Comments.Single(comment => comment.Id == 1);

            blogDbContext.Comments.Remove(commentInfo);

            blogDbContext.SaveChanges();

            Console.WriteLine(@"Comment #{0} deleted", commentInfo.Id);
        }

        private static void UpdateData(BlogDbContext blogDbContext)
        {
            User userInfo = blogDbContext.Users.Single(user => user.UserName == "GBotev");

            string oldName = userInfo.FullName;

            userInfo.FullName = "Georgi Botev";

            blogDbContext.SaveChanges();

            Console.WriteLine(@"User '{0}' has been renamed to '{1}'", oldName, userInfo.FullName);
        }

        private static void CreateNewPost(BlogDbContext blogDbContext)
        {
            Post post = new Post()
            {
                AuthorId = 2,
                Title = "Random Title",
                Body = "Random Content",
                Date = DateTime.Now
            };
            blogDbContext.Posts.Add(post);
            blogDbContext.SaveChanges();
            Console.WriteLine("Post #{0} created!", post.Id);
        }

        private static void OrderPostsAuthors(BlogDbContext blogDbContext)
        {
            var users = blogDbContext.Users.SelectMany(user => user.Posts,
                                       (user, post) => new { user.UserName, user.FullName }).OrderByDescending(user => user);

            foreach (var user in users)
            {
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine();
            }
        }


        private static void SelectAuthorOfSpecificPost(BlogDbContext blogDbContext)
        {
            var author = blogDbContext.Users.SelectMany(user => user.Posts,
                            (user, post) => new { user.UserName, user.FullName, post.Id }).Single(post => post.Id == 4);

            Console.WriteLine("Username: {0}", author.UserName);
            Console.WriteLine("Full Name: {0}", author.FullName);
            Console.WriteLine();
        }

        private static void JoinsAuthorsWithTitles(BlogDbContext blogDbContext)
        {
            var users = blogDbContext.Users.SelectMany(user => user.Posts,
                            (user, post) => new { user.UserName, post.Title });

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Post Title: {0}", user.Title);
                Console.WriteLine();
            }
        }

        private static void OnlyUsersWithPosts(BlogDbContext blogDbContext)
        {
            List<User> users = blogDbContext.Users.Select(user => user).Where(user => user.Posts.Count > 0).ToList();
            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine("Posts Count: {0}", user.Posts.Count);
                Console.WriteLine();
            }
        }

        private static void OrderByTwoColumns(BlogDbContext blogDbContext)
        {
            var users = blogDbContext.Users.Select(user => new
            {
                user.UserName,
                user.FullName
            }).OrderByDescending(user => user.UserName).
                ThenByDescending(user => user.FullName)
                .ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine();
            }
        }

        private static void OrderByUserName(BlogDbContext blogDbContext)
        {
            var users = blogDbContext.Users.Select(user => new
            {
                user.UserName,
                user.FullName
            }).OrderBy(user => user.UserName).ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full Name: {0}", user.FullName);
                Console.WriteLine();
            }
        }

        private static void ListTitleAndBodyFromPosts(BlogDbContext blogDbContext)
        {

            List<User> users = blogDbContext.Users.Select(user => user).ToList();
            var posts = blogDbContext.Posts.Select(post => new
            {
                post.Title,
                post.Body
            }).ToList();

            foreach (var post in posts)
            {
                Console.WriteLine("Title: {0}", post.Title);
                Console.WriteLine("Content: {0}", post.Body);
                Console.WriteLine();
            }
        }

        private static void ListAllUsers(List<User> users)
        {
            foreach (User user in users)
            {
                Console.WriteLine("ID: {0}", user.Id);
                Console.WriteLine("Name: {0}", user.FullName);
                Console.WriteLine("Comments Count:", user.Comments.Count);
                Console.WriteLine("Posts Count:", user.Posts.Count);
                Console.WriteLine();
            }
        }

        private static void ListAllPosts(BlogDbContext blogDbContext)
        {
            List<Post> posts = blogDbContext.Posts.Select(post => post).ToList();

            foreach (var post in posts)
            {
                Console.WriteLine("Title: {0}", post.Title);
                Console.WriteLine("AuthorId: {0}", post.AuthorId);
                Console.WriteLine("Comments Count: {0}", post.Comments.Count);
                Console.WriteLine("Tags Count: {0}", post.Tags.Count);
                Console.WriteLine();
            }
        }
    }
}
