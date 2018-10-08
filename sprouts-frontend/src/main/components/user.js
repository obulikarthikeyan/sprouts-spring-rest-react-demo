import React from 'react';
import { connect } from 'react-redux';

const User = ({ id, firstName, lastName, emailId, phoneNumber, isActive, timeCreated, timeUpdated, dispatch }) => (
    <tr>
        <td>{firstName}</td>
        {lastName && <td>{lastName}</td>}
        <td>{emailId}</td>
        {phoneNumber && <td>{phoneNumber}</td>}
        <td>{timeCreated}</td>
        <td>{timeUpdated}</td>
    </tr>
);

export default connect()(User);

