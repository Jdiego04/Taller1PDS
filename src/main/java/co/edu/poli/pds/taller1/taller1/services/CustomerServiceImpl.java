package co.edu.poli.pds.taller1.taller1.services;

import co.edu.poli.pds.taller1.taller1.mapper.CustomerDTOToCustomer;
import co.edu.poli.pds.taller1.taller1.persistence.entity.Customer;
import co.edu.poli.pds.taller1.taller1.persistence.repository.CustomerRepository;
import co.edu.poli.pds.taller1.taller1.services.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerDTOToCustomer customerDTOToCustomer;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CustomerDTO customer) {
        if(isAdult(customer.getBirthdate())){
            repository.save(customerDTOToCustomer.mapper(customer));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Customer customer) {
        repository.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public boolean isAdult(Date birthdate) {
        LocalDate birthdateLocal = birthdate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthdateLocal, currentDate);

        return period.getYears() >= 18;
    }


}
