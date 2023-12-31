package procesos.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procesos.inventario.model.Address;
import procesos.inventario.model.User;
import procesos.inventario.repositorio.AddressRepository;

import java.util.List;
import java.util.Optional;
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;
    public Address createAddress(Address address, Long idUser){
        User user = userService.getUserById(idUser);
        if(user == null){
            throw new  RuntimeException("User not found");
        }
        address.setUser(user);
        return addressRepository.save(address);
    }
    public Address disabledAddress(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if(address.isEmpty()){
            throw new RuntimeException("Address not fun");
        }
        address.get().setStatus(Boolean.FALSE);
        return addressRepository.save(address.get());
    }
    public Address getAddressById(Long id){
        Optional<Address> address = addressRepository.findById(id);
        if(address.isEmpty()){
            throw new RuntimeException("Address not fun");
        }
        return address.get();
    }
    public List<Address> getAllAddress(){
        List<Address> address = (List<Address>) addressRepository.findAll();
        if(address.isEmpty()){
            throw new RuntimeException("Address not fun");
        }
        return address;
    }

}