class: center, middle

# implicitly yours
### Steven Gangstead
### code and slides at https://github.com/gangstead/implicitly-yours

---

# Overview

- Implicit…
- forms
- types
- conversions

---

# implicit parameters example

```scala
implicit val n: Int = 5
def add(x: Int)(implicit y: Int) = x + y
add(5) // takes n from the current scope
add(5) (1) //can always call explicitly
```

---
# Implicit class

---

# Implicit class example

---
# Implicit conversions

- Formerly called Pimp pattern / pimplicits.  For "pimp my library"
- As of [PNW Scala](http://www.pnwscala.org) 2014 libraries are now "bedazzled" instead.

---
# Implicit conversions continued

Implicit Conversion
    If one calls a method m on an object o of a class C, and that class does not support method m, then Scala will look for an implicit conversion from Cto something that does support m. A simple example would be the method map on String:
```scala
"abc".map(_.toInt)
```

String does not support the method map, but StringOps does, and there’s an implicit conversion from String to StringOps available (see implicit def augmentString onPredef).

We can make our own ScalaEnthusiastsStringOps...

---
#Example: ScalaEnthusiastsStringOps

---
# The End
## Code is available
### https://github.com/gangstead/implicitly-yours
