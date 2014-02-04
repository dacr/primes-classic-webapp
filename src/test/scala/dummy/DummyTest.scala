/*
 * Copyright 2012 David Crosson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dummy

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import primesengine.HibernateUtil
import org.scalatest.BeforeAndAfter
import org.scalatest.BeforeAndAfterAll
import primesengine.PersistedCheckedValue
import primesengine.Storage

@RunWith(classOf[JUnitRunner])
class DummyTest extends FunSuite with ShouldMatchers {

  test("Simple test") {
    val prime = new PersistedCheckedValue()
    prime.value=3
    prime.prime=true
    prime.digitCount=1
    prime.nth=2

    val storage = new Storage[PersistedCheckedValue](prime)
    
    // CREATE
    storage.beginTransaction()    
    storage.insert(prime)
    storage.commit()
    
    // UPDATE
    storage.beginTransaction()
    prime.nth=99
    storage.update(prime)
    storage.commit()
    
    // READ
    storage.beginTransaction()    
    val primeFromDB = storage.getById(3L)
    primeFromDB.prime should equal(true)
    primeFromDB.nth should equal(99)
    storage.commit()
    
    // DELETE
    storage.beginTransaction()    
    storage.delete(primeFromDB)
    storage.commit()
    
  }

}
