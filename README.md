# Survey-Feedback
project

Goals

The goals  for any project structure are:
-----------------------------------------

    1. There must be consistency in the structure
    2. I must be able to find what I am looking for quickly
    3. I must be able to find the code I am looking for based on file names and file location
    4. It has to scale

1.Basic Approch
----------------

                  --app/            //all of the files to be used in production
                  ------css/        //css files
                  ------img/        //image files
                  ------index.html  //app layout file (the main html template file of the app)
                  ------js/         // javascript files
                  ------------app.js              // application
                  ------------controllers.js      //application controllers
                  ------------directives.js       //application directives
                  ------------filters.js          //custom angular filters
                  ------------services.js         //custom angular services
                  ------lib/        //angular and 3rd party javascript libraries
                  ------partials/   //angular view partials (partial html templates)
                  config/           //config files for running unit tests with Testacular/Karma
                  scripts/          //handy shell/js/ruby scripts (run unit tests and dev server)
                  test/             //test source files and libraries


Problems with this approch.......
----------------------------------
      As soon as the page gets any more complex than having one main view and one controller, things start to get large/hard to read. We also have the problem where we are mixing directives/controllers/services/config etc… all in the same JS file. You also have the problem of large amounts of associated markup winding in index.html.



2.Standard Structure
---------------------
                 app/
                ----- shared/   // acts as reusable components or partials of our site
                ---------- sidebar/
                --------------- sidebarDirective.js
                --------------- sidebarView.html
                ---------- article/
                --------------- articleDirective.js
                --------------- articleView.html
                ----- components/   // each component is treated as a mini Angular app
                ---------- home/
                --------------- homeController.js
                --------------- homeService.js
                --------------- homeView.html
                ---------- blog/
                --------------- blogController.js
                --------------- blogService.js
                --------------- blogView.html
                ----- app.module.js
                ----- app.routes.js
                assets/
                ----- img/      // Images and icons for your app
                ----- css/      // All styles and style related files (SCSS or LESS files)
                ----- js/       // JavaScript files written for your app that are not for angular
                ----- libs/     // Third-party libraries such as jQuery, Moment, Underscore, etc.
                index.html
  
  Problems with this approch.......
------------------------------------
      Enter problem two. What happens when my project has heaps of controllers/services etc… I now have directories that could have a lot of files and none of them are particularly easy to find.
      
      
3.Modularization according to features...
------------------------------------------

                      app/
                      ----- shared/   // acts as reusable components or partials of our site
                      ---------- sidebar/
                      --------------- sidebarDirective.js
                      --------------- sidebarView.html
                      ---------- article/
                      --------------- articleDirective.js
                      --------------- articleView.html
                      ----- components/   // each component is treated as a mini Angular app
                      ---------- home/
                      --------------- homeController.js
                      --------------- homeService.js
                      --------------- homeView.html
                      ---------- blog/
                      --------------- blogController.js
                      --------------- blogService.js
                      --------------- blogView.html
                      ----- app.module.js
                      ----- app.routes.js
                      assets/
                      ----- img/      // Images and icons for your app
                      ----- css/      // All styles and style related files (SCSS or LESS files)
                      ----- js/       // JavaScript files written for your app that are not for angular
                      ----- libs/     // Third-party libraries such as jQuery, Moment, Underscore, etc.
                      index.html
                      
Benifits...
------------
      There is consistency with naming. This one is pretty self-explanatory. We can find what we are looking for quickly. If I want to find the controller for the foo component, I know exactly where that is going to live. I know that the controller logic for the foo component is going to be in the foo.controller.js file. It doesn’t matter how many extra components you add to the application, you aren’t going to be overwhelmed at all.
