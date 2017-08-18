import React, {Component} from 'react';

// CONTROLLER VIEW

export default class CreateMessageForm extends Component {
    render() {
        return (
            <form onSubmit={this.props.onSubmit}>
                <div className="form-group">
                    <label>
                        Name
                    </label>
                    <input
                        className="form-control"
                        type="text"
                        name="name"
                        value={this.props.name} // it`s "props" because it comes from its parent
                        onChange={this.props.onChange}
                    />
                </div>

                <div className="form-group">
                    <label>
                        Decription
                    </label>
                    <textarea
                        className="form-control"
                        name="description"
                        value={this.props.description} // it`s "props" because it comes from its parent
                        onChange={this.props.onChange}
                    />
                </div>

                <input type="submit"
                       value="Create Team"
                       className="btn btn-primary"
                       disabled={this.props.inputDisabled}/>
            </form>
        );
    }
}