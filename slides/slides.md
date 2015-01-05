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