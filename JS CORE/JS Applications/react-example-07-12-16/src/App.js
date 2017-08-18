import React, { Component } from 'react';
import './App.css';
import Header from './Header'
import Footer from './Footer'
import Person from './Person'
import Counter from './Counter'
import List from './List'
import Table from './Table'
import PersonForm from './PersonForm'

class App extends Component {
  render() {
      let towns = ['Varna','Burgas','Sofia'];
      let columns = ['Name','Age'];
      let rows = [
          ["Pesho",17], ["Gosho",22], ["Maria",17]
      ];
      function editPerson(personFormData) {
          alert(JSON.stringify(personFormData));
      }

      function delFunc() {
          alert('delete clicked');
      }
    return (
      <div className="App">
          <Header/>
        <p className="App-intro">
         Hello, React !
        </p>
          <Person person="Gosho" phone="0878659854"/>
          <Counter start="5"/>
          <Counter start="10"/>
          <Counter start="20"/>
          <List items={towns}/>
          <Table columns={columns} rows={rows} onDelete={12}/>

          <PersonForm onsubmit={editPerson}/>
          <PersonForm onsubmit={editPerson} />
          <PersonForm name="Gosho" age="20"
                      onsubmit={editPerson} />


          <Footer/>
      </div>
    );
  }
}

export default App;
