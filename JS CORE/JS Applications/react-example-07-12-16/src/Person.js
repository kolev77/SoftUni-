import React, { Component } from 'react';

let Person = React.createClass({
    render: function() {
        return (
            <div>
                <h1>{this.props.person}</h1>
                <p>Tel. {this.props.phone}</p>
            </div>
        )
    }
});

export default Person;