import * as React from "react";
import {withRouter} from "react-router";
import {saveIngredient} from "../services/ingredientServices";

class AddIngredient extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            name:"",
            amount:"",
            isSpicy:false,
            isVeggie:false
        }
    }

    render() {
        console.log(this.state);
        return(
            <div className="container">
                <div className="row">
                    <form className="card">
                        <h4 className="text-upper text-left">Add/Edit Ingredient</h4>
                        <div className="form-group row">
                            <label htmlFor="ingredient" className="col-sm-4 offset-sm-1 text-left">Ingredient name</label>
                            <div className="col-sm-6">
                                <input value={this.state.name} onChange={this.onInputChange} name="name" type="text" className="form-control" id="ingredient" placeholder="Ingredient name"/>
                            </div>
                        </div>
                        <div className="form-group row">
                            <label htmlFor="amount" className="col-sm-4 offset-sm-1 text-left">Amount</label>
                            <div className="col-sm-6">
                                <input value={this.state.amount} onChange={this.onInputChange} name="amount" type="text" className="form-control" id="amount" placeholder="Amount"/>
                            </div>
                        </div>
                        <div className="form-group row">
                            <label htmlFor="veggie" className="col-sm-4 offset-sm-1 text-left">Veggie</label>
                            <div className="col-sm-6 col-xl-4">
                                <input checked={this.state.isVeggie} onChange={this.onCheckBoxChange} name="isVeggie" type="checkbox" className="form-control" id="veggie"/>
                            </div>
                        </div>

                        <div className="form-group row">
                            <label htmlFor="spicy" className="col-sm-4 offset-sm-1 text-left">Spicy</label>
                            <div className="col-sm-6 col-xl-4">
                                <input checked={this.state.isSpicy} onChange={this.onCheckBoxChange} name="isSpicy" type="checkbox" className="form-control" id="spicy"/>
                            </div>
                        </div>

                        <div className="form-group row">
                            <div
                                className="offset-sm-1 col-sm-3  text-center">
                                <button
                                    type="submit"
                                    className="btn btn-primary text-upper" onClick={this.addIngredient}>
                                    Save
                                </button>
                            </div>
                            <div
                                className="offset-sm-1 col-sm-3  text-center">
                                <button
                                    className="btn btn-warning text-upper" onClick={this.clearForm}>
                                    Reset
                                </button>
                            </div>
                            <div
                                className="offset-sm-1 col-sm-3  text-center">
                                <button
                                    className="btn btn-danger text-upper" onClick={this.cancelForm}>
                                    Cancel
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
    onInputChange = (event) => {
        let state = {};
        state[event.target.name] = event.target.value;
        this.setState(state);
    };

    onCheckBoxChange = (event) =>{
        let state = {};
        state[event.target.name] = event.target.checked;
        this.setState(state);
    };

    clearForm = (event) => {
        event.preventDefault();
        this.setState({
            name: "",
            amount: "",
            isSpicy: false,
            isVeggie: false
        });
    };

    cancelForm = (event) => {
        event.preventDefault();
        this.props.history.push("/ingredients");
    };

    addIngredient = (event) => {
        event.preventDefault();
        saveIngredient(this.state);
        this.props.history.push("/ingredients");
    }

}

export default withRouter(AddIngredient);