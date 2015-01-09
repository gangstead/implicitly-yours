implicitly-yours
================

Sample Code for Dallas Scala Enthusiasts presentation

## The Slides
### TL;DR [Slides here](https://gangstead.github.io/implicitly-yours)

Since the default branch is gh-pages, go to http://gangstead.github.io/implicitly-yours to view the slides.

To view the slides locally start a [static http server](https://gist.github.com/willurd/5720255) from that directory.  My preferred way:

```
# one time, to install the dependency
> npm install -g http-server

# start the server in the base directory. -o flag opens browser
> http-server -o
```

## The Code
### TL;DR `sbt run`
### Running

The sample code has multiple main classes.  From the command line type `sbt run` and you will get prompted to choose one:
```
gangstead$ sbt run
[info] Loading global plugins from /Users/gangstead/.sbt/0.13/plugins
[info] Loading project definition from /Users/gangstead/scala/implicitly-yours/project
[info] Set current project to implicitly-yours (in build file:/Users/gangstead/scala/implicitly-yours/)
[info] Compiling 3 Scala sources to /Users/gangstead/scala/implicitly-yours/target/scala-2.11/classes...
[warn] Multiple main classes detected.  Run 'show discoveredMainClasses' to see the list

Multiple main classes detected, select one to run:

[1] gangstead.akka.main
[2] gangstead.ImplicitlyImplicit
[3] gangstead.ImplicitClassUseCase
[4] gangstead.ImplicitParams
[5] gangstead.ImplicitConversionUseCase

Enter number: 2
```
If you want to make changes to the code and see compiler output in real time then use the command `sbt ~compile`

```
gangstead$ sbt ~compile
[info] Loading global plugins from /Users/gangstead/.sbt/0.13/plugins
[info] Loading project definition from /Users/gangstead/scala/implicitly-yours/project
[info] Set current project to implicitly-yours (in build file:/Users/gangstead/scala/implicitly-yours/)
[info] Compiling 3 Scala sources to /Users/gangstead/scala/implicitly-yours/target/scala-2.11/classes...
[success] Total time: 7 s, completed Jan 9, 2015 12:32:05 PM
1. Waiting for source changes... (press enter to interrupt)
_
```
Now whenever you save a file sbt will recompile and display any warnings or errors.

### Building IDE files
#### Eclipse
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

#### IDEA
Intellij IDEA can import SBT projects natively.
