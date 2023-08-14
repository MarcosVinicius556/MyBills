import { BrowserRouter } from "react-router-dom";
import { AuthProvider } from "./contexts/AuthContext";
import RoutesApp from "./routes/RoutesApp";

import { ToastContainer } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import LogoutButton from "./components/LogoutButton";

function App() {

  return (
    <BrowserRouter>
      <AuthProvider>
        <ToastContainer />
        <RoutesApp />
        <LogoutButton />
      </AuthProvider>
    </BrowserRouter>
  )
}

export default App
