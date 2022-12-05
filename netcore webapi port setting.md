netcore webapi port setting


          CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                   webBuilder.UseUrls("http://localhost:5202");
                    webBuilder.UseStartup<Startup>();
                });
    }
}