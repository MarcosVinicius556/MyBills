import './base-input.css';

export default function BaseInput({ labelText, type, placeHolder, name, register }) {
    return(
        <div className="input-box">
                <label>{ labelText }</label>
                <input 
                    type={ type } 
                    placeholder={ placeHolder }
                    { ...register }
                />
        </div>
    );
}