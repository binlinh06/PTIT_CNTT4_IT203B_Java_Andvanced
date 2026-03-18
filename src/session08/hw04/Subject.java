package session08.hw04;

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
