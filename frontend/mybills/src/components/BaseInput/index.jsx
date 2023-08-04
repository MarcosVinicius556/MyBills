import './base-input.css';

export default function BaseInput({ labelText, type, placeHolder, changeState }) {
    return(
        <div className="input-box">
                <label>{ labelText }</label>
                <input 
                    type={ type } 
                    placeholder={ placeHolder } 
                    onChange={(e) => changeState(e.target.value)}
                />
        </div>
    );
}