import React, {Component} from 'react';
import Team from './Team';
import {loadTeams} from '../../models/team';
// CONTROLLER VIEW

export default class MessagesPage extends Component {
    constructor(props) {
        super(props);

        this.state = {
            messages: []
        };
        this.onLoadSuccess = this.onLoadSuccess.bind(this);
    };

    componentDidMount() {
        loadTeams(this.onLoadSuccess);
    }


    onLoadSuccess(response) {
        this.setState({ messages: response});
    }

    render() {
        return (
            <div>
                <h1>Messages</h1>
                {this.state.messages.map((t, i) => {
                    return <Message key={i} name={t.name} description={t.description} teamId={t._id}/>
                })}
            </div>
        );
    }
}