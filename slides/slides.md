class: center, middle

# implicitly yours
### Steven Gangstead
### code and slides at https://github.com/gangstead/implicitly-yours
@Gangstead
.footnote[![:scale 20%](slides/credera.jpg)]
---

# Overview

Implicit…
- Parameters
- Conversion
- Context Bounds
- Where do they come from?

---

# Implicit parameters

- Parameters to method calls that if not called explicitly the complier tries to fill them in automatically.
- Name is ignored, match is based on type only
- Exactly one match must be in scope ([see code](https://github.com/gangstead/implicitly-yours/blob/gh-pages/src/main/scala/gangstead/ImplicitParams.scala))

---

# implicit parameters example

```scala
implicit val n: Int = 5
def add(x: Int)(implicit y: Int) = x + y
add(5) // takes n from the current scope
add(5) (1) //can always call explicitly
```
---

# Why Implicit parameters?

- Cleaner code
- Focus on what the code does

```scala
import scala.concurrent.duration._
import akka.util.Timeout
import akka.pattern.ask
implicit val timeout = Timeout(5 seconds)

val future = myActor.ask("hello")(timeout)
val future = myActor.ask("hello")
val future = myActor ask "hello"
val future = myActor ? "hello"
```
---
# Implicit conversions

- Call a method that a type doesn't have.  Compiler checks for an implicit conversion to a type that does have the method.
- Limitations ???
- Formerly called Pimp pattern / pimplicits.  For "pimp my library"
- As of [PNW Scala](http://www.pnwscala.org) 2014 libraries are now "bedazzled" instead.

---
# Implicit conversions continued

Implicit Conversion
    If one calls a method m on an object o of a class C, and that class does not support method m, then Scala will look for an implicit conversion from C to something that does support m. A simple example would be the method map on String:
```scala
"abc".map(_.toInt)
```
---
# Basic Example
```scala
case class Enthusiast(level: Int)

class HiConvert {
  implicit def toEnthusiast(i : Int) = Enthusiast(i)
  def takesAnEnthusiast(e : Enthusiast) = println(s"Received $e")

  val randomHuman = 2 //an int
  println("Enthusiasm level: " + randomHuman.level)
  takesAnEnthusiast(randomHuman)
}
```

---
# Practical example:
String does not support the method map, but StringOps does, and there’s an implicit conversion from String to StringOps available (see implicit def augmentString onPredef).

We can make our own ScalaEnthusiastsStringOps...

---
# Example: ScalaEnthusiastsStringOps

---

# Why Implicit Conversions?

- Extend classes that you can't otherwise modify
---

# Implicit Context Bounds

Start here: http://docs.scala-lang.org/tutorials/FAQ/finding-implicits.html#context-bounds

---

# Where do Implicits Come From?
1. _Current scope_
 - Implicits defined in current scope
 - Explicit imports
 - Wildcard imports
 - Same scope in other files
2. _Associated types in_
 - Companion objects of a type
 - Implicit scope of an argument’s type (2.9.1)
 - Implicit scope of type arguments (2.8.0)
 - Outer objects for nested types
 - Other dimensions

.footnote[[Source and Examples](http://docs.scala-lang.org/tutorials/FAQ/finding-implicits.html#where-do-implicits-come-from)]

---
# Compiler considerations
- Since they can get you in trouble Scala compiler wants you to be sure you actually want conversions.
- It will work, but you'll see this warning:

.smaller[
```
[warn] there was one feature warning; re-run with -feature for details
```
]

- Add "-feature" to scalacOptions in build.sbt

.smaller[
```
[warn] /Users/stevegangstead/workspace/scala/ws/implicitly-yours/src/main/scala/gangstead/ImplicitConversion.scala:9:
  implicit conversion method toEnthusiast should be enabled
[warn] by making the implicit value scala.language.implicitConversions visible.
[warn] This can be achieved by adding the import clause 'import scala.language.implicitConversions'
[warn] or by setting the compiler option -language:implicitConversions.
[warn] See the Scala docs for value scala.language.implicitConversions for a discussion
[warn] why the feature should be explicitly enabled.
[warn]   implicit def toEnthusiast(i : Int) = Enthusiast(i)
[warn]                ^
```
]
---
# Removing those warnings
- In build.sbt enable project wide
```
scalacOptions += "-language:implicitConversions"
```
- Per file (or even per scope block)
```scala
import scala.language.implicitConversions
```
---

# The End
## Code is available
### https://github.com/gangstead/implicitly-yours
