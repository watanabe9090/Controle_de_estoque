//$('.ui.fullscreen.modal').modal('show');


const itensVenda = {};


function adicionarItemNaVenda(id) {
    let itemEstocado = $(`#item${id}`).val();
    let quantidade = $(`qtd${id}`).val();

    itensVenda[`${id}``] = {itemEstocado, quantidade};
    console.log(itemEstocado, quantidade);


//    if(quantidade < 0 ou quantidade > itemEstocado.quantidade)

//    itensVenda[itemEstocado.id] = {itemEstocado, quantidade};
//    mostrarTabelaVenda();
}


// Cria as linhas da table com os valores
function makeVendaTable() {
    let index = 0;
    let fiedName = "itensVendidos";
    let carrinhoTableBody = doument.getElementById('carrinhoTableBody').innerHTML = '';
    for(item in itensVenda) {
        let row = `<tr>
            <td type="hidden" name="${fieldName}[${index}}].itemEstocado" value="${itensVenda[item].itemEstocado.id}"></td>
            <td type="hidden" name="${fieldName}[${index}}].quantidade" value="${itensVenda[item].quantidade}"></td>
            <td type="hidden" name="${fieldName}[${index}}].precoVenda" value="${itensVenda[item].precoVenda}"></td>
        </tr>`;
        carrinhoTableBody.innerHTML += row;
    }

}
