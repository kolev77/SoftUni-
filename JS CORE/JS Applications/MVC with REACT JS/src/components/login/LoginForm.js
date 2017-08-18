import React, {Component} from 'react';

// CONTROLLER VIEW

export default class LoginForm extends Component {
    render() {
        return (
            <form onSubmit={this.props.onSubmit}>
                <div className="form-group">
                    <label>
                        Username
                    </label>
                    <input
                        className="form-control"
                        type="text"
                        name="username"
                        value={this.props.username} // it`s "props" because it comes from its parent
                        onChange={this.props.onChange}
                        disabled={this.props.inputDisabled}
                    />
                </div>

                <div className="form-group">
                    <label>
                        Password
                    </label>
                    <input className="form-control"
                           type="password"
                           name="password"
                           value={this.props.password}
                           onChange={this.props.onChange}
                           disabled={this.props.inputDisabled}
                    />
                </div>
                <input type="submit"
                       value="Login"
                       className="btn btn-primary"
                       disabled={this.props.inputDisabled}
                />
            </form>
        );
    }
}