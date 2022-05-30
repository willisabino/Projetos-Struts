
function inputAlterar(action, idAlt, idParam){
  location.href=action+"?"+idAlt+"="+idParam;
  bloquear()
  submit();
}


function inputEditar(action, idEdit, idParam){
  location.href=action+"?"+idEdit+"="+idParam;
  submit();
}

setTimeout(function bloquear() {
	 const id = document.querySelector('#id').value;
	 const nome = document.querySelector('#nome').value;

    if(id && nome){
        document.querySelector('#alterar').hidden = false;
        document.querySelector('#inserir').hidden = true;
        return;
    }
    document.querySelector('#alterar').hidden = true;
    document.querySelector('#inserir').hidden = false;
}, 1000);