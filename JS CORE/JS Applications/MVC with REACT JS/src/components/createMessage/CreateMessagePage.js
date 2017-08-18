import React, {Component} from 'react';
import CreateForm from './createMessageForm';
import {create} from '../../models/team';
//import observer from '../../models/observer';
// CONTROLLER VIEW

export default class CreateMessagePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            from: "",
            to: "",
            message: "",
            inputDisabled: true
        };
        this.onChangeHandler = this.onChangeHandler.bind(this);
        this.onSubmitHandler = this.onSubmitHandler.bind(this);
        this.onCreateSuccess = this.onCreateSuccess.bind(this);
    }

    onChangeHandler(event) {
        event.preventDefault();
        let newState = {};
        newState[event.target.from] = event.target.value;

        if (event.target.from === "from") {
            if (event.target.value.length < 3) {
                newState.inputDisabled = true;
            } else {
                newState.inputDisabled = false;

            }
        };
        this.setState(newState);
    }

    onSubmitHandler(event) {
        event.preventDefault();

        if (this.state.from.length < 3) {
            alert("Message name must be at least 3 characters long.")
        }
        create(this.state.from,
            this.state.to,
            this.onCreateSuccess);
    }

    onCreateSuccess(result) {
        this.context.router.push("/catalog");
    }

    render() {
        return (
            <div>
                <h1>Create Page</h1>
                <CreateMessageForm
                    name={this.state.name}
                    description={this.state.description}
                    onChange={this.onChangeHandler}
                    onSubmit={this.onSubmitHandler}
                    inputDisabled={this.state.inputDisabled}
                />
            </div>
        );
    }
}

CreateMessagePage.contextTypes = {
    router: React.PropTypes.object
};