import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./component/Login";
import Register from "./component/Register";
import Header from "./component/Header";
import Footer from "./component/Footer";
import Homepage from "./component/Homepage";
import BookDetail from "./component/BookDetail";

function App() {
  const bookdata =
    "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.40YdU1lR2EQdFRfSxnTERQHaHa%26pid%3DApi&f=1&ipt=424399fb34ec8e44e188583a276ecbc5658d84d6f007df78a42ba3a0e5cefbe8&ipo=images";
  const bookTitle = "Atomic Habit";
  const booPrice = "200";
  const auther = "Sahani";
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route
          path="/books"
          element={
            <Homepage
              bookImage={bookdata}
              bookTitle={bookTitle}
              booPrice={booPrice}
              auther={auther}
            />
          }
        />
        <Route
          path="/book-detail?"
          element={
            <BookDetail
              bookImage={bookdata}
              bookTitle={bookTitle}
              booPrice={booPrice}
            />
          }
        />
      </Routes>
      {/* <Footer /> */}
    </BrowserRouter>
  );
}

export default App;
