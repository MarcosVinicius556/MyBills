import { BrowserRouter } from "react-router-dom"
import RoutesApp from "./routes/RoutesApp"
import { UserContext, UserProvider } from "./contexts/UserContext"

function App() {

  return (
    <BrowserRouter>
      <UserProvider>
        <RoutesApp />
      </UserProvider>
    </BrowserRouter>
  )
}

export default App
