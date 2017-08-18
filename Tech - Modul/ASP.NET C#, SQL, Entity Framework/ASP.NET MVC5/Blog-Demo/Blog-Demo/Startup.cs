using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Blog_Demo.Startup))]
namespace Blog_Demo
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
