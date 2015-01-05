implicitly-yours
================

Sample Code for Dallas Scala Enthusiasts presentation

## Building IDE files
### Eclipse
This project includes the plugin to generate Eclipse project files.  From the console:
```
> sbt eclipse
```
Then in Eclipse `File > Import > Existing Projects` and find this project.

### IDEA
Intellij IDEA can import SBT projects natively.


## The Slides
Since the default branch is gh-pages, go to http://gangstead.github.io/implicitly-yours to view the slides.

To view the slides locally start a [static http server](https://gist.github.com/willurd/5720255) from that directory.  My preferred way:

```
> npm install -g http-server # one time, to install the dependency
> http-server
```

Then access the slides at http://localhost:8080/
