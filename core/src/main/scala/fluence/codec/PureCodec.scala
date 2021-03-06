/*
 * Copyright (C) 2017  Fluence Labs Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fluence.codec

/**
 * PureCodec default values.
 */
object PureCodec extends MonadicalEitherArrow[CodecError] {

  /**
   * Summons an implicit codec.
   */
  def codec[A, B](implicit pc: PureCodec[A, B]): PureCodec[A, B] = pc

  /**
   * Shortcut to build a PureCodec.Bijection with two Func's
   */
  def build[A, B](direct: Func[A, B], inverse: Func[B, A]): Bijection[A, B] =
    Bijection(direct, inverse)

  /**
   * Shortcut to build a PureCodec.Bijection with two pure functions
   */
  def build[A, B](direct: A ⇒ B, inverse: B ⇒ A): Bijection[A, B] =
    liftB(direct, inverse)
}
