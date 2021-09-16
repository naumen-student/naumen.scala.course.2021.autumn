object Main extends App {
  val name = "xsitin"
  val scalaThisIs = " Scala! This is "
  println(s"Hello$scalaThisIs$name")

  println(s"Hola$scalaThisIs$name")

  println(s"Guten tag$scalaThisIs$name")

  println(s"Guten tag$scalaThisIs" + name.reverse)

  println(s"Hola$scalaThisIs" + name.reverse)

  println(s"Hello$scalaThisIs" + name.reverse)
}