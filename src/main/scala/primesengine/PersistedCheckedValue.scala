package primesengine

import javax.persistence._

@Table( name = "CheckedValues" )
@Entity
class PersistedCheckedValue(
    _value:Long,
    _prime:Boolean,
    _digitCount:Long,
    _nth:Long
    ) {
  @Id
  var value:Long=_value
  
  @Column(name="isPrime", nullable=false)
  var prime:Boolean=_prime
  
  @Column(name="digitCount", nullable=false)
  var digitCount:Long = _digitCount
  
  @Column(name="nth", nullable=false)
  var nth:Long=_nth
  
  def this() = this(2,false,1,1)
}
