import React from 'react';

class DropDown extends React.Component {
    constructor(props) {
      super(props);
      this.state = {value: 'coconut'};
      this.state1 = {value: 'coconut'};
  
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event) {
      this.setState({value: event.target.value});
    }
  
    handleSubmit(event) {
      alert('Selected KPI: ' + this.state.value);
      event.preventDefault();
    }
  
    render() {
      return (
        <form onSubmit={this.handleSubmit}>
          <label>
          Select the category of KPI:
            <select value={this.state.value} onChange={this.handleChange}>
              <option value="Optimize">Optimize</option>
              <option value="Operate">Operate</option>
              <option value="Inform">Inform</option>
            </select>
          </label>
          <br/>
          <label>
          Select the KPI Name:
            <select value={this.state1.value} onChange={this.handleChange}>
              <option value="Budget Coverage">Budget Coverage</option>
              <option value="Tagging Coverage">Tagging Coverage</option>
              <option value="Anomaly Alert Investigations">Anomaly Alert Investigations</option>
              <option value="RI/SP Coverage">RI/SP Coverage</option>
            </select>
          </label>
          <input type="submit" value="Submit" />
        </form>
      );
    }
  }

  export default DropDown;