import React, {Component} from 'react';
import './Table.css';

let Table = React.createClass({
    delete: function (btn) {
      if(this.props.onDelete){
          this.props.onDelete(btn.parent.parent.key);
      }
    },
    render: function () {
        let component = this;

        let titles = this.props.columns.map(function (col, c) {
            return <th key={c}>{col}</th>
        });

        let rows = this.props.rows.map(function (row, r) {
            return <tr key={r}>{row.map(function (cell, c) {
                return <td key={c}>{cell}</td>;
            })}
            <td><button onClick={component.delete}>Delete</button></td>
            </tr>;
        });

        return <table>
            <thead>
            <tr>
                {titles}
            <td>Actions</td>

            </tr>
            </thead>
            <tbody>{rows}</tbody>
        </table>

    }
    
});

export default Table;