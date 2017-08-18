import React, {Component} from 'react';
import './Header.css';

let Header = React.createClass({
        render: function () {
            return (
                <div className="header">
                    <a href="#">Home</a>
                    <a href="#">Login</a>
                    <a href="#">Register</a>
                </div>
            );
        }
    });
export default Header;
