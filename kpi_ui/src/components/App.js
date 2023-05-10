import React, { useReducer, useState } from 'react';
import './App.css';

const formReducer = (state, event) => {
    return {
        ...state,
        [event.name]: event.value
    }
}

function App() {
    const [formData, setFormData] = useReducer(formReducer, {});
    const [submitting, setSubmitting] = useState(false);

    const handleSubmit = event => {
        event.preventDefault();
        setSubmitting(true);

        setTimeout(() => {
            setSubmitting(false);
        }, 3000);
    }

    const handleChange = event => {
        setFormData({
            name: event.target.name,
            value: event.target.value,
        });
    }

    return(
        <div className="wrapper">
            <h1>Welcome To KPI Service</h1>
            {submitting &&
                <div>
                    You are submitting the following:
                    <ul>
                        {Object.entries(formData).map(([name, value]) => (
                            <li key={name}><strong>{name}</strong>: {value.toString()}</li>
                        ))}
                    </ul>
                </div>
            }
            <form onSubmit={handleSubmit}>
                <fieldset>
                    <center><p>Category</p></center>
                    <label>
                        <div className="buttonHolder">
                        <select name="category" onChange={handleChange}>
                            <option value="">---Please choose an option---</option>
                            <optgroup label="Inform">
                                <option value="Budget Coverage">Budget Coverage</option>
                                <option value="Tagging Coverage">Tagging Coverage</option>
                                <option value="Anomaly Alert Investigations">Anomaly Alert Investigations</option>
                            </optgroup>
                            <optgroup label="Optimize">
                                <option value="RI/SP Coverage">RI/SP Coverage</option>
                                <option value="RI/SP Vacancy">RI/SP Vacancy</option>
                                <option value="IFA Storage">IFA Storage</option>
                                <option value="Old Generation EBS  Usage">Old Generation EBS  Usage</option>
                                <option value="Old Generation Compute Instance Usage">Old Generation Compute Instance Usage</option>
                                <option value="Spot Instance Usage">Spot Instance Usage</option>
                                <option value="Serverless Usage">Serverless Usage</option>
                                <option value="Container Usage">Container Usage</option>
                            </optgroup>
                            <optgroup label="Operate">
                                <option value="Unattached Storage">Unattached Storage</option>
                                <option value="Old Snapshots">Old Snapshots</option>
                                <option value="Idle Compute Instances">Idle Compute Instances</option>
                                <option value="Unattached Elastic IP">Unattached Elastic IP</option>
                                <option value="Weeknight / Weekend Shut Down">Weeknight / Weekend Shut Down</option>
                            </optgroup>
                        </select>
                        </div>
                    </label>
                </fieldset>
                <fieldset>
                    <label>
                        <div className="buttonHolder">
                        <p>Current</p>
                        <input type="number" name="current" min="0" max="100"/>
                        </div>
                    </label>
                </fieldset>
                <div className="buttonHolder">
                    <button type="submit">Submit</button>
                </div>
            </form>
        </div>
    )
}

export default App;
