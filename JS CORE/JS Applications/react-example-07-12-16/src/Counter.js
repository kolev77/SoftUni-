import React, {Component} from 'react';
import './Counter.css';


let Counter = React.createClass({
    getInitialState: function () {
        return {
            count: Number(this.props.start),
            styles: {color: 'blue'}
        };
    },
    increase: function () {
        this.setState({
            count: Number(this.state.count)+1,
            styles: { color: 'green'}
        });
    },
    decrease: function () {
        this.setState({
            count: Number(this.state.count)-1,
            styles: { color: 'red'}
        });
    },
    render: function () {
        return (<div className="counter">Count:
            <b style={this.state.styles}>
                {this.state.count} </b>
            <button type="button" onClick={this.increase}>+</button>
            <button type="button" onClick={this.decrease}>-</button>
            <button type="button">Color</button>
        </div>)

    }
});

export default Counter;