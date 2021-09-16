object Main extends App {
    val name = "Stepan" 
    val text = s" Scala! This is $name" 
    val text1 = "Hello" + text 

    println(text1) 



    val text2 = "Hola" + text 
    println(text2) 

    val text3 = "Guten tag" + text 
    println(text3)

    val inverse_name = name.reverse 
    val inverse_template = text.substring(0, 16) + inverse_name 
    val inv_fst = text1.substring(0, 21) + inverse_name 
    println(inv_fst) 

    val inv_snd = text2.substring(0, 20) + inverse_name 
    println(inv_snd) 


    val inv_thd = "Guten tag" + inverse_template 
    println(inv_thd) 
}
