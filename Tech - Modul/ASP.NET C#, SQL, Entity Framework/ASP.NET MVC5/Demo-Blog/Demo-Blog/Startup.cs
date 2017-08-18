using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Demo_Blog.Startup))]
namespace Demo_Blog
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
