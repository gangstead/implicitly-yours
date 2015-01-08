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

Optionally if you want to include the sources of the dependencies:
```
> sbt
#sbt starts up...
> eclipse with-source=true
```
This will take longer in big projects, but this project is small.  I don't know why you can't just do `sbt eclipse with-source=true`.  That's what the plugin docs say, but it won't work for me.

### IDEA
Intellij IDEA can import SBT projects natively.


## The Slides
Since the default branch is gh-pages, go to http://gangstead.github.io/implicitly-yours to view the slides.

To view the slides locally start a [static http server](https://gist.github.com/willurd/5720255) from that directory.  My preferred way:

```
# one time, to install the dependency
> npm install -g http-server

# start the server in the base directory. -o flag opens browser
> http-server -o
```
