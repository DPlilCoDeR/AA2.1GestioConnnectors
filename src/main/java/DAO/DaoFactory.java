package DAO;

import DAO.impl.ClientDAOImpl;
import DAO.impl.ComandaDAOImpl;
import DAO.impl.ProducteDAOImpl;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private ProducteDAO producteDAO;
    private ClientDAO clientDAO;
    private ComandaDAO comandaDAO;

    private DaoFactory() {
        this.producteDAO = new ProducteDAOImpl();
        this.clientDAO = new ClientDAOImpl();
        this.comandaDAO = new ComandaDAOImpl();

    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public ProducteDAO getProducteDAO() {return producteDAO;}
    public ClientDAO getClientDAO(){return clientDAO;}
    public ComandaDAO getComandaDAO(){return comandaDAO;}

}
