import Navbar from './Navbar';
// ...
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <header>
      <div className="nav-area">
        <Link to="/" className="logo">
          KPI
        </Link>
        <Navbar />
      </div>
    </header>
  );
};

export default Header;
