import React, {Component} from 'react';
import './Team.css';
import {Link} from 'react-router';

export default class Message extends Component {
    render() {
        return (
            <div className="message-box">
                <span className="spanner">from</span>
                <span>{this.props.name}</span>
                <span className="spanner">to</span>
                <p>{this.props.description || "No description"}</p>
                <span className="spanner">Management</span>
                <Link to={"/edit/" + this.props.teamId} className="btn btn-default">Edit</Link>
            </div>
        )
    }
}