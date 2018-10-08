import { createStore, applyMiddleware } from "redux";
import userReducer from '../reducers/user_reducer';
import thunk from 'redux-thunk';

export default () => {
    return createStore(userReducer, applyMiddleware(thunk));
};