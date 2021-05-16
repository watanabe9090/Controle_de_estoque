function mascaraCPF(i) {
    document.getElementById("cpf").style.backgroundColor = "";
        document.getElementById("cpf").style.borderColor = "";
        document.getElementById("cpf").style.color = "";
        document.getElementById("validadeCPF").innerHTML = "";
  var v = i.value;

  if (isNaN(v[v.length - 1])) {
    // impede entrar outro caractere que não seja número
    i.value = v.substring(0, v.length - 1);
    return;
  }

  i.setAttribute("maxlength", "14");
  if (v.length == 3 || v.length == 7) i.value += ".";
  if (v.length == 11) i.value += "-";
}
function mascaraRG(i) {
  var v = i.value;

  if (isNaN(v[v.length - 1])) {
    // impede entrar outro caractere que não seja número
    i.value = v.substring(0, v.length - 1);
    return;
  }

  i.setAttribute("maxlength", "12");
  if (v.length == 2 || v.length == 6) i.value += ".";
  if (v.length == 10) i.value += "-";
}

function validaCPF() {
  let strCPF = document.getElementById("cpf").value;
  strCPF = strCPF.replace(/[^0-9]+/g, "");
  console.log(strCPF);
  var Soma;
  var Resto;
  Soma = 0;
  flag = true;

  if (strCPF == "00000000000") {

    flag = false;
  }

  for (i = 1; i <= 9; i++)
    Soma += parseInt(strCPF.substring(i - 1, i)) * (11 - i);
  Resto = (Soma * 10) % 11;
  if (Resto == 10 || Resto == 11) Resto = 0;
  if (Resto != parseInt(strCPF.substring(9, 10))) {
    flag = false;
  }

  Soma = 0;
  for (i = 1; i <= 10; i++)
    Soma += parseInt(strCPF.substring(i - 1, i)) * (12 - i);
  Resto = (Soma * 10) % 11;
  if (Resto == 10 || Resto == 11) Resto = 0;
  if (Resto != parseInt(strCPF.substring(10, 11))) {
    flag = false;
  }

  if (flag) return flag;
  else {
    document.getElementById("cpf").style.color = "red";
    document.getElementById("cpf").style.borderColor = "red";
    document.getElementById("cpf").style.backgroundColor = "rgb(250, 205, 205)";
    document.getElementById("validadeCPF").innerHTML = "Insira um CPF válido!";
    document.getElementById("cpf").innerHTML = "";
    return flag;
  }
}
