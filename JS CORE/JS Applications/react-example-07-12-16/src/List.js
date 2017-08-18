import React, {Component} from 'react';

let List = React.createClass({
    render: function () {
        // let items = [];
        // let counter = 0;
        // for (let item of this.props.items) {
        //     items.push(<li key={++counter}>{item}</li>)

        let items = this.props.items.map(function (item, index) {
            return <li key={index}>{item}</li>
            });
        return ( <ul>{items}</ul>)
    }
});

export default List;