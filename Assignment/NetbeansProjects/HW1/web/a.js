function myFunction()
{
 var x = document.getElementById("number").value;
 //alert(name);  // 找到元素 成功
 document.write("<form method = 'post' action = 'child.do'>");
 for(var i=0; i<x; i++){
  document.write("Please enter the name of child: <br>")
  document.write("<input type = 'text' name = 'name' > <br>")
        //docuemnt.wirte("\n")  
 }// 改变内容
 document.write("<input type = 'submit' value = 'submit query'>")
 document.write("</form>");
}
