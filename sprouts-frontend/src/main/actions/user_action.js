import axios from '../js/axios';
const actionTypes = require('../constants/action_types');

const getUsersAction = (users) => ({
    type: actionTypes.GET_USERS_ACTION_TYPE,
    users
});

export const getUsers = () => {
    return (dispatch) => {
        return axios.get('users').then(result => {
            const users = [];

            result.data.forEach(item => {
                users.push(item);
            });

            dispatch(getUsersAction(users));
        });
    };
};