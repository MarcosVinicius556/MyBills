import './submit-button.css';

export default function SubmitButton({ text }) {
    return(
        <input type="submit" value={ text } className="login-btn"/>
    );
}