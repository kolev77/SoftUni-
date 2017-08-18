function domSearch(selector, bool) {

    let container = $(selector);
    container.attr('class', 'items-control');

    let divControls = $('<div class="add-controls"></div>');
    let enterTextLabel = $('<label>Enter text: </label>');
    let inputAddElement = $('<input>');
    let addButton = $('<a class="button" style="display: inline-block">Add</a>');

    enterTextLabel.append(inputAddElement);
    divControls.append(enterTextLabel);
    divControls.append(addButton);
    container.append(divControls);

    let searchControls = $('<div class="search-controls">');
    let saerchLabel = $('<label>Search:</label>');
    saerchLabel.on('input', function () {
        search()
    });

    let searchInput = $('<input>');

    saerchLabel.append(searchInput);
    searchControls.append(saerchLabel);
    container.append(searchControls);

    let resultControls = $('<div class="result-controls"></div>');
    let itemsList = $('<ul class="items-list"></ul>');
    resultControls.append(itemsList);
    container.append(resultControls);

    addButton.on('click', function () {
        let textValue = inputAddElement.val();
        let li = $('<li class="list-item"></li>');
        let del = $('<a class="button">X</a>');
        del.click({li: li}, deleteItem);     // how to select current "li"

        let strong = $('<strong></strong>');
        strong.text(textValue);

        li.append(del);
        li.append(strong);
        itemsList.append(li);
        search();
    });

    function deleteItem(event) {
        event.data.li.remove();
        search();
    }

    function search() {
        let searchVal;
        if (bool) {
            searchVal = searchInput.val()
        } else {
            searchVal = searchInput.val().toLowerCase()
        }

        let allLi = $('.items-list li').each((index, item)=> {

            if (bool) {
                if (item.textContent.substr(1).indexOf(searchVal) !== -1) {
                    $(item).css('display', '')
                } else {
                    $(item).css('display', 'none')
                }
            } else {
                if (item.textContent.substr(1).toLowerCase().indexOf(searchVal) !== -1) {
                    $(item).css('display', '')
                } else {
                    $(item).css('display', 'none')
                }
            }
        })
    }
}